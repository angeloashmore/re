(ns re.panels.post
  (:require [re.layouts.main]))

(defn main
  []
  [re.layouts.main/main
   [:p "This is the post panel"]
   [:p [:a {:href "/"} "Go home"]]])
