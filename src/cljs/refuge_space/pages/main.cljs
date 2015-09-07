(ns refuge-space.pages.main
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [refuge-space.components.navbar :refer [navbar]]))

(defn current-page []
  [:div
    [navbar (session/get :nav-state)]
    [:div.container.theme-showcase {:role "main"}
      [(session/get :current-page)]]])
