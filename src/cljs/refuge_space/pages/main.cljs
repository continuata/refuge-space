(ns refuge-space.pages.main
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [refuge-space.components.navbar :refer [navbar]]))

(defn current-page []
  [:div.container-fluid
    [navbar (session/get :nav-state)]
    [:div.container-fluid
      [(session/get :current-page)]]])
