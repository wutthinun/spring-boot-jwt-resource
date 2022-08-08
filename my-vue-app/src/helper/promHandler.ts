export const promHandler = async <T> (prom: Promise<T>): Promise<[T | null, any]> => {
  try {
    return [await prom, null];
  } catch (error) {
    return [null, error];
  }
}
