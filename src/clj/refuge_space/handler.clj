(ns refuge-space.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found resources]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [include-js include-css]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring.middleware.reload :refer [wrap-reload]]
            [environ.core :refer [env]]
            [refuge-space.fb-server :as fb-server]))

(def home-page
  (html
   [:html
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1"}]
     (include-css "bower_components/bootstrap/dist/css/bootstrap.min.css")
     (include-css "bower_components/bootstrap/dist/css/bootstrap-theme.min.css")
     (include-css (if (env :dev) "css/fonts.css" "css/fonts.min.css"))
     (include-css (if (env :dev) "css/signup.css" "css/signup.min.css"))
     (include-css (if (env :dev) "css/navbar.css" "css/navbar.min.css"))
     (include-css (if (env :dev) "css/site.css" "css/site.min.css"))]
    [:body
     [:div#app
      [:h3 "ClojureScript has not been compiled!"]
      [:p "please run "
       [:b "lein figwheel"]
       " in order to start the compiler"]]
     (include-js "bower_components/jquery/dist/jquery.min.js")
     (include-js "bower_components/bootstrap/dist/js/bootstrap.min.js")
     (include-js "js/app.js")]]))

(defroutes routes
  (GET "/" [] home-page)
  (resources "/")
  (not-found "Not Found"))

(def app
  (let [handler (wrap-defaults #'routes site-defaults)]
    (fb-server/run)
    (if (env :dev) (-> handler wrap-exceptions wrap-reload) handler)))
