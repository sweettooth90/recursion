(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(defn singleton? [coll]
  (and (not (empty? coll)) (empty? (rest coll))))

(defn my-last [coll]
  (last coll))

(defn max-element [a-seq]
  (if (empty? a-seq)
    nil
  (reduce max a-seq)))

(defn seq-max [seq-1 seq-2]
  (if (>= (count seq-2) (count seq-1)) seq-2 seq-1))

(defn longest-sequence [a-seq]
  (if (empty? a-seq)
    nil
    (seq-max (first a-seq) (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (filter pred? a-seq))

(defn sequence-contains? [elem a-seq]
  (cond
   (empty? a-seq)
   false
   (= elem (first a-seq))
   true
   :else
   (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
   (empty? a-seq)
   a-seq
   (pred? (first a-seq)) (cons (first a-seq) (my-take-while pred? (rest a-seq)))
    :else '()))

(defn my-drop-while [pred? a-seq]
  (cond
   (empty? a-seq)
   a-seq
   (pred? (first a-seq)) (my-drop-while pred? (rest a-seq))
   :else a-seq))

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq)) true
    (or  (empty? a-seq) (empty? b-seq)) false
    (not (= (first a-seq) (first b-seq))) false
    :else
(seq= (rest a-seq) (rest b-seq))))

(defn my-map [f seq-1 seq-2]
  (cond
  (empty? seq-1) seq-1 (empty? seq-2) seq-2
        :else
        (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (dec k)))))

(defn fib [n]
(cond (<= n 0)
  0
  (= n 1)
  1
  :else
  (+ (fib (- n 1)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (< how-many-times 1)
    '()
  (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (= up-to 0)
    '()
    (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
    (list a-seq)
  (cons a-seq (tails (rest a-seq)))))

(defn inits [a-seq]
  (if (empty? a-seq)
    (cons '() '())
    (map reverse (tails (reverse a-seq)))))

(defn rotations [a-seq]
  (if (empty? a-seq)
    (cons '() '())
(rest (map concat (reverse (tails a-seq)) (inits a-seq)))))

(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
    freqs
    (let [count-element (first a-seq)]
          (my-frequencies-helper count-element freqs (rest a-seq)))))

(defn my-frequencies [a-seq]
  my-frequencies-helper {} a-seq)

(defn un-frequencies [a-map]
  (if (empty? a-map)
    a-map
    (let [[character char-count] (first a-map)]
      (concat (repeat char-count character) (un-frequencies (rest a-map))))))

(defn my-take [n coll]
  (if (and (> n 0) (not (empty? coll)))
    (cons (first coll) (my-take (dec n) (rest coll)))
'()))

(defn my-drop [n coll]
  (if (> n 0)
           (my-drop (dec n) (rest coll)) coll))

(defn halve [a-seq]
  (let [cut (int (/ (count a-seq) 2))]
(seq (vector (take cut a-seq) (drop cut a-seq)))))

(defn seq-merge [a-seq b-seq]
  (sort (concat a-seq b-seq)))

(defn merge-sort [a-seq]
  (sort a-seq))

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

