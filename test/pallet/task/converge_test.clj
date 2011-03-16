(ns pallet.task.converge-test
  (:use pallet.task.converge)
  (:require [pallet.core :as core])
  (:use
   clojure.test
   pallet.test-utils))


(with-private-vars [pallet.task.converge [build-args]]
  (deftest build-args-test
    (core/defnode a {})
    (core/defnode b {})
    (is (= [{a 1} :task []] (build-args [a 1])))
    (is (= [{a 1 b 2} :task []] (build-args [a 1 b 2])))
    (is (= [{a 1} :task [:b]] (build-args [a 1 :b])))
    (is (= [{a 1} :prefix "a" :task [:b]] (build-args ['a a 1 :b])))))
