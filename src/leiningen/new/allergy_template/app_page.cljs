(ns {{ns-name}}.views.app-page
  (:require [reagent.core :as r]
            [reagent-forms.core :as forms]
            [json-html.core :refer [edn->hiccup]]))

(def the-app (r/atom {:clicker1 0
                      :clicker2 0}))


(defn dump-dom []
  [:div
   [:h2 "App"]
   (edn->hiccup @the-app)])


(defn clicker-component [doc id]
   [:p
    [:code (str id)] " has value: "
    [:input {:type "button" :value (get-in @doc id)
             :on-click #(swap! doc update-in id inc)}]
    [:em " (click to increment)"]])


(defn math-app [doc]
  [:div
   [clicker-component doc [:clicker1]]
   [clicker-component doc [:clicker2]]
   [:p "Advanced programming techniques reveal that their product is: "
    (* (:clicker1 @doc) (:clicker2 @doc))]])

(def data)


(defn page-dom []
  [forms/bind-fields
   [:div
    [:h1 "The application "]
    [math-app the-app]]
   the-app])
