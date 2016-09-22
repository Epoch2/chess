package se.jvester.chess.Board;

import java.util.List;
import java.util.ArrayList;

public class Path {
    private List<Position> nodes = new ArrayList<>();

    public Path() {}

    public Path(List<Position> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Position position) {
        nodes.add(position);
    }

    public Position getDestination() {
        return nodes.get(nodes.size() - 1);
    }

    public List<Position> getNodes() {
        return nodes;
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public String toString() {
        String nodeString = "";

        for (Position node : nodes) {
            nodeString += node;

            // Add an arrow (->) to the end if there are more nodes
            if (nodes.indexOf(node) != (nodes.size() - 1)) {
                nodeString += " -> ";
            }
        }

        return nodeString;
    }
}
