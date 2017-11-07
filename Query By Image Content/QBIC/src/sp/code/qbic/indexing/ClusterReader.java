package sp.code.qbic.indexing;

import sp.code.qbic.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.store.FSDirectory;


public class ClusterReader extends Indexer {

    private org.apache.lucene.index.IndexReader reader;

    public void open(int id) throws IOException {
        reader = org.apache.lucene.index.IndexReader.open(FSDirectory.open(new File(Constants.CLUSTER_IDX
                + "-" + id)));
    }

    public void close() throws IOException {
        reader.close();
    }

   
    public List<Index> getIndexes() {
        List<Index> indexes = new ArrayList<Index>();
        
        int numDocs = reader.numDocs();
        
        for (int i = 0; i < numDocs; i++) {
            try {
                Document document = reader.document(i);
                List<Fieldable> f = document.getFields();

                Index index = new Index();
                for (Fieldable fieldable : f) {
                    Field field = (Field) fieldable;
                    Method m = Index.class.getDeclaredMethod("set" + field.name(), new Class[]{String.class});
                    m.invoke(index, new Object[]{field.stringValue()});
                   
                }
                
                indexes.add(index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return indexes;
    }
}
