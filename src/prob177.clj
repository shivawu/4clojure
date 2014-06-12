; 177. Balancing Brackets
(fn [s]
  (let [rights {\} \{, \] \[, \) \(}
        lefts (set (vals rights))]
    (loop [[c & cs :as s] s stk '()]
      (cond
        (empty? s) (empty? stk)
        (lefts c) (recur cs (cons c stk))
        (rights c) (when (= (first stk) (rights c)) (recur cs (rest stk)))
        :else (recur cs stk)))))

