(ns refuge-space.components.navbar
    (:require [reagent.core :as reagent]))

(defn navbar []
  [:nav {:class "navbar navbar-default"}
    [:div {:class "container"}
    [:div {:class "navbar-header"}
      [:button {:type "button", :class "navbar-toggle collapsed", :data-toggle "collapse", :data-target ".navbar-collapse"}
        [:span {:class "sr-only"} "Toggle navigation"]
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}] ]
          [:a {:class "navbar-brand", :href "#"} "stayhere.org.uk"]]
    [:div {:class "navbar-collapse collapse"}
      [:ul {:class "nav navbar-nav"}
        [:li {:class "active"} [:a {:href "#/"} "Home"]]
        [:li [:a {:href "#/admin"} "Admin"]]

        [:li [:a {:href "#/about"} "About"]]
        [:li {:class "dropdown"}
          [:a {:href "#",
               :class "dropdown-toggle",
               :data-toggle "dropdown",
               :role "button",
               :aria-haspopup "true",
               :aria-expanded "false"} "Dropdown "
            [:span {:class "caret"}]]
          [:ul {:class "dropdown-menu"}
            [:li [:a {:href "#"} "Action"]]
            [:li [:a {:href "#"} "Another action"]]
            [:li [:a {:href "#"} "Something else here"]]
            [:li {:role "separator", :class "divider"}]
            [:li {:class "dropdown-header"} "Nav header"]
            [:li [:a {:href "#"} "Separated link"]]
            [:li [:a {:href "#"} "One more separated link"]]]]]]]])
