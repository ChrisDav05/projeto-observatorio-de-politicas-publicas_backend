@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){

        this.repository = repository;

    }

    public List<CategoriaResponse> listar(){

        return repository.findAll()

                .stream()

                .map(CategoriaMapper::toResponse)

                .toList();

    }

    public CategoriaResponse salvar(CategoriaRequest dto){

        Categoria categoria = CategoriaMapper.toEntity(dto);

        categoria = repository.save(categoria);

        return CategoriaMapper.toResponse(categoria);

    }

}