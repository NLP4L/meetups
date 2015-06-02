val CORPUS = Array(
  "alice ate an apple",
  "mike likes an orange",
  "an apple is red"
)

val index = "/tmp/index-simple"

def schema(): Schema = {
  val analyzer = Analyzer(new org.apache.lucene.analysis.core.WhitespaceAnalyzer)
  val fieldTypes = Map(
    "text" -> FieldType(analyzer, true, true, true, true)
  )
  val analyzerDefault = analyzer
  Schema(analyzerDefault, fieldTypes)
}

def doc(text: String): Document = {
  Document(Set(
      Field("text", text)
    )
  )
}

val writer = IWriter(index, schema)

CORPUS.foreach(text => writer.write(doc(text)))

writer.close
