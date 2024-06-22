package heroRepository;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryTests
{
    Hero hero;
    HeroRepository heroRepository;
    @Test
    public void test_Hero_Constructor_Should_Initialize_Correctly()
    {
        hero = new Hero("Ludmil", 10);
        Assert.assertEquals("Ludmil", hero.getName());
        Assert.assertEquals(10, hero.getLevel());
    }
    @Test
    public void test_HeroRepository_Constructor_Should_Initialize_Correctly()
    {
        heroRepository = new HeroRepository();
        Assert.assertEquals(0, heroRepository.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_HeroRepository_create_Should_Throw_Exception_If_Hero_Null()
    {
        heroRepository = new HeroRepository();
        hero = null;
        heroRepository.create(hero);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_HeroRepository_create_Should_Throw_Exception_If_Hero_Exist()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        heroRepository.create(hero);
        heroRepository.create(hero);

    }
    @Test
    public void test_HeroRepository_create_Should_Add_Hero_Correctly()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        Assert.assertEquals("Successfully added hero Ludmil with level 10", heroRepository.create(hero));
    }
    @Test(expected = NullPointerException.class)
    public void test_HeroRepository_remove_Should_Throw_Exception_If_Hero_Name_Is_Null()
    {
        heroRepository = new HeroRepository();
        hero = new Hero(null, 10);
        heroRepository.remove(hero.getName());

    }
    @Test(expected = NullPointerException.class)
    public void test_HeroRepository_remove_Should_Throw_Exception_If_Hero_Name_Is_Empty()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("  ", 10);
        heroRepository.remove(hero.getName());

    }
    @Test
    public void test_HeroRepository_remove_Should_Remove_Correctly_And_Return_True()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Ludmil"));
    }
    @Test
    public void test_HeroRepository_remove_Should_Remove_Correctly_And_Decrease_Size_Of_Collection()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        heroRepository.create(hero);
        heroRepository.remove("Ludmil");
        Assert.assertEquals(0, heroRepository.getCount());
    }
    @Test
    public void test_HeroRepository_getHeroWithHighestLevel_Should_Return_Hero_With_Highest_Level()
    {
        heroRepository = new HeroRepository();
        //hero = new Hero("Ludmil", 10);
        Hero hero1 = new Hero("Ludmil1", 11);
        Hero hero2 = new Hero("Ludmil2", 12);
        Hero hero3 = new Hero("Ludmil3", 13);
        Hero hero4 = new Hero("Ludmil4", 14);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        heroRepository.create(hero4);
        Assert.assertEquals(hero4, heroRepository.getHeroWithHighestLevel());
    }
    @Test
    public void test_HeroRepository_getHero_Should_Return_Existing_Hero_By_Name()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHero("Ludmil"));
    }
    @Test
    public void test_HeroRepository_getHero_Should_Return_Null_If_Hero_Does_Not_Exist()
    {
        heroRepository = new HeroRepository();
        hero = new Hero("Ludmil", 10);
        heroRepository.create(hero);
        Assert.assertEquals(null, heroRepository.getHero("Ivan"));
    }
    @Test
    public void test_HeroRepository_getHeroes_Should_Return_Heroes_Collection()
    {
        heroRepository = new HeroRepository();
        Hero hero1 = new Hero("Ludmil1", 11);
        Hero hero2 = new Hero("Ludmil2", 12);
        Hero hero3 = new Hero("Ludmil3", 13);
        Hero hero4 = new Hero("Ludmil4", 14);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        heroRepository.create(hero4);
        List<Hero> expected = new ArrayList<>();
        //expected = List.of(hero1, hero2, hero3, hero4);
        expected.add(hero1);
        expected.add(hero2);
        expected.add(hero3);
        expected.add(hero4);
        Collection<Hero> unmodifiable = Collections.unmodifiableCollection(expected);
        Assert.assertArrayEquals(unmodifiable.toArray(), heroRepository.getHeroes().toArray());
    }
}
