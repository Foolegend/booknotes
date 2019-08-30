package cn.lh.restful.api;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

public class GroupInfo {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupInfo)) return false;
        GroupInfo groupInfo = (GroupInfo) o;
        return Objects.equals(id, groupInfo.id) &&
                Objects.equals(name, groupInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    public static boolean getConfFile(String userName, String password, String ipAddr, String clusterPath, String localPath) {
        boolean isAuthed = false;
        boolean status = false;
        try {
            status = InetAddress.getByName(ipAddr).isReachable(1500);
            System.out.println(status);
            if (status) {
                Connection conn = new Connection(ipAddr);
                conn.connect();
                isAuthed = conn.authenticateWithPassword(userName, password);
                System.out.println(isAuthed);
                if (isAuthed) {
                    Session session = conn.openSession();
                    SCPClient scpClient = conn.createSCPClient();
                    scpClient.get(clusterPath, localPath);
                    session.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isAuthed;
    }
}
