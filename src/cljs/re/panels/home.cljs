(ns re.panels.home
  (:require [re.layouts.main :as main-layout]))

(defn headline
  [text]
  [:h2.normal.lh-title.mv4.f5 text])

(defn main
  []
  [main-layout/main
   [headline "til that walt disney gave his housekeeper, thelma pearl howard, shares of disney stock every year for her birthday and christmas. she died a multi-millionaire at the age of 79."]
   [headline "i feel like the photograph i took today could have been taken in the 1950s!"]
   [:p [:a {:href "/about"} "Go to /about"]]])
