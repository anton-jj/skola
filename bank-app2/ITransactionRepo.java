    public interface  ITransactionRepo {
    void save(ITransaction transaction);
    void delete(int id);
    List<ITransaction> findAll();
    Optional<ITransaction> findById(int id);
    List<ITransaction> findByDateRange(LocalDate startDate, LocalDate endDate);
}
