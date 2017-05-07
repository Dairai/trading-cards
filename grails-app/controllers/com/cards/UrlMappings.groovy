package com.cards

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/howtouse"(view:"/howtouse")
	    "/membership"(view:"/membership")
	    "/siterules"(view:"/siterules")
	    "/about"(view:"/about")
	    "/credits"(view:"/credits")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
