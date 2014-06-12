; 133. A nil key
(fn [k m]
  (true? (and ((set (keys m)) k) (nil? (m k)))))

