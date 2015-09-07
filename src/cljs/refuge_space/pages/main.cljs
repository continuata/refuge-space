(ns refuge-space.pages.main
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [refuge-space.components.navbar :refer [navbar]]))

(defn current-page []
  [:div.container
    [:nav
      [navbar]]
    [(session/get :current-page)]])
