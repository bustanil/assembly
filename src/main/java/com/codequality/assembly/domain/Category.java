package com.codequality.assembly.domain;

import org.apache.commons.lang.Validate;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import javax.persistence.*;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    @Sort(type = SortType.COMPARATOR, comparator = CategoryComparator.class)
    private SortedSet<Category> subCategories = new TreeSet<Category>(new CategoryComparator());

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    @Sort(type = SortType.COMPARATOR, comparator = BuildComparator.class)
    private SortedSet<Build> builds = new TreeSet<Build>(new BuildComparator());

    Category() {
    }

    public Category(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public void addSubCategory(Category category) {
        Validate.notNull(category, "category to be added cannot be null!");
        subCategories.add(category);
        category.setParent(this);
    }

    public void addBuild(Build build) {
        Validate.notNull(build, "build to be added cannot be null!");
        builds.add(build);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(SortedSet<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getParent() {
        return parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public SortedSet<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(SortedSet<Build> builds) {
        this.builds = builds;
    }

    public static class CategoryComparator implements Comparator<Category> {

        @Override
        public int compare(Category o1, Category o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class BuildComparator implements Comparator<Build> {

        @Override
        public int compare(Build o1, Build o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
