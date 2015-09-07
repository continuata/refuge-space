(ns refuge_space.store
  (:require
    [reagent.core :as reagent :refer [atom]]
    [matchbox.core :as m]))

(def fb_root (m/connect "https://confide.firebaseio.com/"))

(def downloads (atom {}))

(defn init-store [user]
  (prn (str "uid" (:uid user))))
  ; (m/listen-list (m/equal-to (m/order-by-child (fb_purchases_root (:uid user)) :email) (:email user)) #(reset! purchases %))
  ; (m/listen-list (fb_downloads_root (:uid user)) #(reset! downloads %)))
