(ns {{ns-name}}.reagent-helpers
  (:require [clojure.string :as string]
            [reagent.core :as r]
            [reagent-forms.core :as forms]))


;;; Mostly taken from the reagent-forms examples.
;;; Assumes bootstrap.


(defn row [label input]
  [:div.row
   [:div.col-xs-2 [:label label]]
   [:div.col-xs-10 input]])


(defn input [label type id]
  (row label [:input.form-control {:field type :id id}]))


(defn errmsg-bar [id event message]
  [:div.row
   [:div.col-xs-2]
   [:div.col-xs-10
    [:div.alert.alert-danger
     {:field :alert :id id :event event}
     message]]])


;;; (Doesn't really belong here).
;;; Simple email static validity checker.
(defn bad-email? [s]
  ;; Derived from
  ;; http://www.dotnet-tricks.com/Tutorial/javascript/
  ;;  UNDS040712-JavaScript-Email-Address-validation-using-Regular-Expression.html
  (not (.exec (js/RegExp. "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") s)))



;;; Build an input field, and add one or more error-checkers to it.
;;;
;;; For example:
;;;  (errchecked-input "age" :numeric :user.age
;;;     #(< % 18)   "You must be over 18"
;;;     #(>= % 100) "Sorry, too old to play")
;;; or:
;;;  (errchecked-input "email" :email :user.email
;;;     bad-email? "Invalid email address")
(defn errchecked-input [label type id & err-handlers]
  [:div
   (input label type id)
   (doall (map #(apply errmsg-bar id %) (partition 2 err-handlers)))])
