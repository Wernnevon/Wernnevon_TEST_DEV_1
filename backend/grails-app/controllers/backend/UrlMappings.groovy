package backend

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        name api1: "/api/stocks"(parseRequest: true) {
            action = [GET: "list", POST: "save"]
        }
        name api2: "/api/companies"(parseRequest: true) {
            action = [GET: "list", POST: "save"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
