val index = "/tmp/index-hmm"

val CORPUS = Array(
  "Jecel/NNP ate/VB an/AT apple/NNP ./.",
  "Frecy/NNP likes/VB an/AT orange/NNP ./.",
  "An/AT apple/NNP is/VB red/JJ ./."
)

val indexer = HmmModelIndexer(index)

CORPUS.foreach{ text =>
  val pairs = text.split("\\s+")
  val doc = pairs.map{h => h.split("/")}.map{i => (i(0).toLowerCase(), i(1))}
  indexer.addDocument(doc)
}

indexer.close()

// try to browse terms on each fields
//
// nlp4l> open("/tmp/index-hmm")
// nlp4l> status
// nlp4l> browseTerms("begin"); nt
// nlp4l> browseTerms("class"); nt
// nlp4l> browseTerms("class_2g"); nt
// nlp4l> browseTerms("word_class"); nt
// nlp4l> browseTerms("word"); nt
// nlp4l> close

// execute part-of-speech tagging on an unknown text
val model = HmmModel(index)
val tagger = HmmTagger(model)

tagger.tokens("jecel likes an apple .")
