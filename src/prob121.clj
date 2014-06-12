; 121. Universal Computation Engine
(fn eval-exp [exp]
  (fn [vars]
    (cond
      (integer? exp) exp
      (symbol? exp) (vars exp)
      :else (let [eval-sub #((eval-exp %) vars)
                  [op & [x y :as subs]] exp]
              (cond
                (= op '+) (apply + (map eval-sub subs))
                (= op '-) (- (eval-sub x) (eval-sub y))
                (= op '*) (apply * (map eval-sub subs))
                (= op '/) (/ (eval-sub x) (eval-sub y)))))))

