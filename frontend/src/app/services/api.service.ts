import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private url = 'http://localhost:8080/';
  constructor(private httpClient: HttpClient) {}
  getStocks(company: string, numberHours: number) {
    const params = 'stocks/?name=' + company + '&&numberHours=' + numberHours;
    return this.httpClient.get(this.url + params);
  }
  getCompanies() {
    const params = 'company';
    return this.httpClient.get(this.url + params);
  }
}
