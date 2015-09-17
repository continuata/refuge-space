(ns stayhere.pages.main
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [stayhere.components.navbar :refer [navbar]]))

(defn current-page []
  [:div.container-fluid
    [:div.background]  
    [navbar (session/get :nav-state)]
    [:div.container-fluid
      [(session/get :current-page)]]])
