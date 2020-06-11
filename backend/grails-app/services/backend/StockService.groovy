package backend

import grails.gorm.transactions.Transactional

@Transactional
class StockService {
    def getStocks(Company company, int numbersOfHoursUntilNow) {
        long start = System.currentTimeMillis()
        List<Stock> stocklist = new ArrayList<>()
        int i = 0
        Stock.findAllByCompanyID(company.getId() as int).forEach({e->
            if(i<numbersOfHoursUntilNow*60){
                stocklist.add(e)
                println('Price:' + e.price )
                println('Date:' + e.priceDate)
            }
            i++
        })
        println(stocklist.size() + ' Stocks')
        long end = System.currentTimeMillis()
        long duration = (end - start)
        println('duration: ' + duration + ' milliseconds')
        return stocklist
    }
}
