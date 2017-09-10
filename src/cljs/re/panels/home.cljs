(ns re.panels.home)

(defn main
  []
  [:div
   [:p
    [:a {:href "/about"} "Go to /about"]]
   [:p "Or stay here! I don't care."]])
