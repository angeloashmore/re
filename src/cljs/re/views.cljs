(ns re.views
  (:require [re-frame.core :as re-frame]
            [cljs-css-modules.macro :refer-macros [defstyle]]
            [garden.units :as units]
            [re.panels.home :as home]
            [re.panels.about :as about]))

(defstyle style
  [".conatiner" {:background-color "blue"}])

(defmulti panels identity)
(defmethod panels :home-panel [] [home/main])
(defmethod panels :about-panel [] [about/main])
(defmethod panels :default [] [:div])

(defn main-panel
  []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div {:class (:container style)}
       (panels @active-panel)])))