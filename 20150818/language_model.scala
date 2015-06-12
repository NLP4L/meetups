val index = "/tmp/index-lm"

val CORPUS = Array(
  "Alice ate an apple.",
  "Mike likes an orange.",
  "An apple is red."
)

def schema(): Schema = {
  val builder = AnalyzerBuilder()
  builder.withTokenizer("standard")
  builder.addTokenFilter("lowercase")
  val analyzer = builder.build
  builder.addTokenFilter("shingle", "minShingleSize", "2", "maxShingleSize", "2", "outputUnigrams", "false")
  val analyzer2g = builder.build
  val fieldTypes = Map(
    "word" -> FieldType(analyzer, true, true, true, true),
    "word2g" -> FieldType(analyzer2g, true, true, true, true)
  )
  val analyzerDefault = analyzer
  Schema(analyzerDefault, fieldTypes)
}

// create a language model index
val writer = IWriter(index, schema())

def addDocument(doc: String): Unit = {
  writer.write(Document(Set(
    Field("word", doc),
    Field("word2g", doc)
  )))
}

CORPUS.foreach(addDocument(_))

writer.close()

// try to browse terms in each fields
//
// nlp4l> open("/tmp/index-lm")
// nlp4l> status
// nlp4l> browseTerms("word")
// nlp4l> nt
// nlp4l> browseTerms("word2g")
// nlp4l> nt
// nlp4l> close

// calculate probabilities
//

val reader = RawReader(index)

// P(apple|an) = C(an apple) / C(an)
val count_an_apple = reader.totalTermFreq("word2g", "an apple")
val count_an = reader.totalTermFreq("word", "an")
val prob_apple_an = count_an_apple.toFloat / count_an.toFloat

// P(orange|an) = C(an orange) / C(an)
val count_an_orange = reader.totalTermFreq("word2g", "an orange")
val prob_orange_an = count_an_orange.toFloat / count_an.toFloat

reader.close
