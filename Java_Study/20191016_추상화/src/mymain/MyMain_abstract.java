package mymain;

import myutil.Animal;
import myutil.Cat;
import myutil.Circle;
import myutil.Dog;
import myutil.Pig;
import myutil.Rect;
import myutil.Shape;
import myutil.Triangle;

public class MyMain_abstract {

	public static void main(String[] args) {

		Animal[] a_array = { new Dog(), new Cat(), new Pig() };
		Shape[] s_array = { new Rect(), new Triangle(), new Circle() };

		동물왈(a_array);
		그려라(s_array);
	}

	static void 동물왈(Animal[] a_array) {
		System.out.println("--동물왈--");
		for (Animal 동물 : a_array) {
			동물.cry();
			동물.eat();

		}
		System.out.println();

	}

	static void 그려라(Shape[] s_array) {
		System.out.println("--도형--");
		for (Shape 도형 : s_array)
			도형.draw();
		System.out.println();

	}

}
