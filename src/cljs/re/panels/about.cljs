(ns re.panels.about
  (:require [re.layouts.main]))

(defn main
  []
  [re.layouts.main/main
   [:p "This is the about panel"]
   [:p [:a {:href "/"} "Go home"]]])
