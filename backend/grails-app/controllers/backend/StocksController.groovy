package backend

import grails.converters.JSON
import org.grails.web.json.JSONObject

class StocksController {
    static responseFormats = ['json', 'html']
    static defaultAction = "stocks"
    StockService stockService = new StockService()
    static allowedMethods = [list:'GET',
                             show:'GET',
                             edit:['GET', 'POST'],
                             save:'POST',
                             update:['POST','PUT'],
                             delete:['POST','DELETE']
    ]

    def list() {
        String companyName = params.name
        String numberHoursParams = params.numberHours
        int numberHours = numberHoursParams as Integer
        Company empresa = Company.findByName(companyName)
        List<Stock> stockList = stockService.getStocks(empresa, numberHours)
        respond stockList
    }
}
