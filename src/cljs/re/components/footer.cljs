(ns re.components.footer
  (:require [re.config :as config]))

(defn main
  []
  [:footer.bt.b--black-05
   [:div.mw7.center.flex.f7.black-50.justify-between
    [:p.ma3 config/version]
    [:p.ma0 [:a.db.pa3.blue.link {:href "#top"} "go to top"]]]])
