(ns stayhere.components.validation)

(def postcode_regex #"^(?:[A-Za-z]\d ?\d[A-Za-z]{2})|(?:[A-Za-z][A-Za-z\d]\d ?\d[A-Za-z]{2})|(?:[A-Za-z]{2}\d{2} ?\d[A-Za-z]{2})|(?:[A-Za-z]\d[A-Za-z] ?\d[A-Za-z]{2})|(?:[A-Za-z]{2}\d[A-Za-z] ?\d[A-Za-z]{2})$")

(defn is-valid?
  "Validate type matches Regex format"
  [type value]
  (case type
    "name" (if (re-find #".{3}.+" value) true false)
    "email" (if (re-find #".+@.+\..+" value) true false)
    "postcode" (if (re-find postcode_regex value) true false)))
