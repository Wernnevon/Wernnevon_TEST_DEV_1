package backend

class CompanyController {
    static responseFormats = ['json', 'html']
    static defaultAction = "stocks"
    static allowedMethods = [list:'GET',
                             show:'GET',
                             edit:['GET', 'POST'],
                             save:'POST',
                             update:['POST','PUT'],
                             delete:['POST','DELETE']
    ]
    def list() {
        respond Company.list()
    }
}
