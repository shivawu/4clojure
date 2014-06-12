; 92. Read Roman numerals
(fn [s]
  (let [mapping {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000}
        numbers (map mapping s)
        fs (reduce (fn [[res last] v]
                     (prn "Res=" res " last=" last " v=" v)
                     (if (and (> last 0) (< last v))
                       [(+ res (- v last)) 0]
                       [(+ res last) v])) [0 0] numbers)]
    (apply + fs)))

