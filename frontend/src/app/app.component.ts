import { ApiService } from './services/api.service';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { StandardDeviationService } from './services/standard-deviation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private stocks: Subscription = new Subscription();
  private companies: Subscription = new Subscription();
  private stndDeviation: any;
  constructor(
    private apiService: ApiService,
    private stnd: StandardDeviationService,
  ) {
    this.listCompanies();
  }
  title = 'frontend';
  candidate = 'Candidato 1';
  stocksArray = [];
  companiesArray = [];
  media;
  standardDeviation = 0;
  numberHours = 1;

  showCompanies = [];

  // tslint:disable-next-line: use-lifecycle-interface
  ngOnInit() {
  }
  // tslint:disable-next-line: use-lifecycle-interface
  async listCompanies() {
    if (this.companiesArray.length === 0) {
      this.companies = this.apiService.getCompanies().subscribe(data => {
        // tslint:disable-next-line: forin
       for (const i in data) {
         this.companiesArray.push(data[i]);
       }
     });
    }
  }
  loadStock(name) {
    return this.stocksArray;
  }

  getCompanies() {
    let stocks = [];
    let dp;
    for (let i = 0; i < this.companiesArray.length ; i++) {
      this.stocks = this.apiService.getStocks(this.companiesArray[i].name, this.numberHours).subscribe(data => {
        stocks = Array.of(data);
        this.stocksArray = stocks;
        dp = this.stnd.getStandardDeviation(stocks);
        this.companiesArray[i].dp = dp;
        console.log(this.companiesArray[i].dp);
       });
    }
  }
}
