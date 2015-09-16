(ns stayhere.prod
  (:require [stayhere.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
