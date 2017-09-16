(ns re.layouts.main
  (:require [re.components.header :as header]
            [re.components.footer :as footer]
            [garden.color :as color]))

(defn main
  [& children]
  [:div.sans-serif.black
   {:style {:-webkit-font-smoothing "antialiased"}}
   [:div#top]
   [header/main]
   [:main.mw7.center
    (map-indexed #(with-meta %2 {:key %1}) children)]
   [footer/main]])
