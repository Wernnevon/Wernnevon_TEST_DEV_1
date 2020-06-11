package backend

import groovy.time.TimeDuration

class BootStrap {

    def init = { servletContext ->
        Company amazon = new Company(name: 'Amazon', segment: 'E-Commerce').save()
        Company netflix = new Company(name: 'Netflix', segment:  'Streaming').save()
        Company ford = new Company(name:  'Ford', segment: 'Vehicle').save()

        int day = new Date().getDate()
        int minutes = new Date().getMinutes()
        int hour = new Date().getHours()
        int month = new Date().getMonth()
        int k
        int m = 0
        int mes = 6
        int dias = day
        int hora = hour
        int minutos = minutes

        for (k = 30; k>0; k--){
            if(m==5){
                m = 0
                dias = dias - 2
            }
            if(hora<18){
                while (hora>=10){
               
                if (minutos<=0){
                    minutos = 60
                    hora--
                }
                BigDecimal priceAmzn = Math.random()
                BigDecimal priceNetfx = Math.random()
                BigDecimal priceFrd = Math.random()
                Stock amznStock = new Stock(companyID: amazon.getId(), price: priceAmzn * 1000, priceDate: new Date(120, month, dias, hora, minutos)).save()
                Stock frdStock = new Stock(companyID: ford.getId(), price: priceFrd * 1000, priceDate: new Date(120, month, dias, hora, minutos)).save()
                Stock ntfxStock = new Stock(companyID: netflix.getId(), price: priceNetfx * 1000, priceDate: new Date(120, month, dias, hora, minutos)).save()
                minutos--
            }
                if(dias<1){
                    dias = 31
                    month--
                }
            dias--
            m++
            }
            hora = 17
            minutos = 59
        }
    }
    def destroy = {
    }
}
