; 171. Intervals
#(remove nil?
   (apply conj
     (reduce (fn [[acc [st ed :as itv]] x]
               (cond
                 (nil? itv) [acc [x x]]
                 (= x ed) [acc itv]
                 (= x (inc ed)) [acc [st x]]
                 :else [(conj acc itv) [x x]]))
       [[] nil] (sort %))))

