(ns {{ns-name}}.views.user-page
  (:require [clojure.string :as string]
            [reagent.core :as r]
            [reagent-forms.core :as forms]
            [{{ns-name}}.reagent-helpers :as helpers]
            [json-html.core :refer [edn->hiccup]]))

(def the-user (r/atom {:user {:first-name "John"
                             :last-name "Smith"
                             :email "JSmith@zmail.com"
                             :user-id ""}}))


(defn dump-dom []
  [:div
   [:h2 "User"]
   (edn->hiccup @the-user)])


(defn page-dom []
  [forms/bind-fields
   [:div
    [:h1 "User info"]
    (helpers/errchecked-input "first name" :text :user.first-name
                              empty? "First name is empty"
                              #(< (js/parseInt %) 18) "You must be over 18"
                              #(= % "John") "No johns allowed here")
    (helpers/errchecked-input "last name" :text :user.last-name
                              empty?  "Last name is empty!")
    (helpers/errchecked-input "age" :numeric :user.age
                              #(empty? (str %)) "Please supply your age"
                              #(< % 18) "You must be over 18"
                              #(>= % 100) "Sorry, too old to play")
    (helpers/errchecked-input "email" :email :user.email
                              helpers/bad-email? "Invalid email address")]
   the-user])

