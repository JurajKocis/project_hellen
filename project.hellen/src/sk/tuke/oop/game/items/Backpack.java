package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.Item;

import java.util.*;

public class Backpack implements ActorContainer<Item>
{
    private int capacity;
    private List<Item> content;

    public Backpack(int capacity)
    {
        this.capacity = capacity;
        content = new ArrayList<>();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName()
    {
        return "Backpack";
    }

    @Override
    public List<Item> getContent() // vráti kopiu zoznamu
    {
        return new ArrayList<>(content);
    }

    @Override
    public void add(Item actor) throws ArrayIndexOutOfBoundsException
    {
        if(content.size() < capacity)
        {
            content.add(0, actor);
        }

        else
            throw new ArrayIndexOutOfBoundsException("Kapacita batohu prekročená");
    }

    @Override
    public void remove(Item actor) throws NoSuchElementException
    {
        if(content.isEmpty() || !content.contains(actor))
            throw new NoSuchElementException("V batohu nieje žiadny item");
        else
            content.remove(actor);
    }

    @Override
    public Iterator<Item> iterator()
    {
        return content.iterator();
    }

    @Override //posledne vlozeny item do batohu
    public Item peek()
    {
        if(content.isEmpty())
            return null;
        else
            return content.get(0);
    }

    @Override
    public void shiftContent()
    {
        Collections.rotate(content, -1);
    }
}
