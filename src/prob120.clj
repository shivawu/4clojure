; 120. Sum of square of digits
(fn [s]
  (let [sum-sq-digits (fn [x]
                        (apply + (map (comp #(* % %) #(Integer/parseInt (str %))) (str x))))]
    (count (filter #(< % (sum-sq-digits %)) s))))

