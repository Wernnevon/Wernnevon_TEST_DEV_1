import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StandardDeviationService {

  constructor() { }
  getStandardDeviation(data: Array<any>) {
    // tslint:disable-next-line: prefer-const
      let soma = 0;
      let dp;
      let varianca = 0;
      let media;
      // tslint:disable-next-line: forin
      data[0].forEach(e => {
        soma = soma + e.price;
      });
      media = soma / data[0].length;
    // tslint:disable-next-line: no-shadowed-variable
      data[0].forEach(element => {
      varianca = varianca + ((media - element.price) * (media - element.price));
    });
      varianca = varianca / data[0].length;
      dp = Math.sqrt(varianca);
      return dp as number;
  }
}
