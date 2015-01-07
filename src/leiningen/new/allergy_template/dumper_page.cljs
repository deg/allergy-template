(ns {{ns-name}}.views.dumper-page
  (:require [reagent.core :as r]
            [reagent-forms.core :as forms]
            [json-html.core :refer [edn->hiccup]]
            {{ns-name}}.session
            {{ns-name}}.views.user-page
            {{ns-name}}.views.app-page))


(defn dump-dom []
  [:div
   [:h2 "Wrapper"]
   (edn->hiccup @{{ns-name}}.session/app-state)])

(defn page-dom []
  [:div
   [:h1 "State dump"]
   [dump-dom]
   [{{ns-name}}.views.app-page/dump-dom]
   ({{ns-name}}.views.user-page/dump-dom)])

