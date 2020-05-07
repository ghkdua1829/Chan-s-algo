package SWEA;

public class SWEA_1812_수정이의타일자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Rectangle {
		int min, max;

		public Rectangle(int width, int height) {
			if (width < height) {
				min = width;
				max = height;
			} else {
				min = height;
				max = width;
			}
		}
	}
}
