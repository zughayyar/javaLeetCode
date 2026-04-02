void main() {
    System.out.println("Hello World!");

    ProductExceptSelf productExceptSelf = new ProductExceptSelf();
    int[] nums = {1, 2, 3, 4};
    int[] result = productExceptSelf.productExceptSelf(nums);
    System.out.println(Arrays.toString(result));
}
