package vez.jpa.model;

import javax.persistence.*;

@Entity
public class Activity {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY) // owner side: it doesn't have mappedBy, and can decide how the association is mapped: with a join table
    @JoinTable(name="ref_category_activity",
            joinColumns={@JoinColumn(name="activities_id")},
            inverseJoinColumns={@JoinColumn(name="Category_id")})
    private Category category;

    private String name;

    public Activity() { }
    public Activity(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}