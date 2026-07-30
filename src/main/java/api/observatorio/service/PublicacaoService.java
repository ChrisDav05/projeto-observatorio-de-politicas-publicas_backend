@Service
public class PublicacaoService {

    private final PublicacaoRepository repository;

    private final CategoriaRepository categoriaRepository;

    public PublicacaoService(

            PublicacaoRepository repository,

            CategoriaRepository categoriaRepository){

        this.repository = repository;
        this.categoriaRepository = categoriaRepository;

    }

    public List<PublicacaoResponse> listar(){

        return repository.findAll()

                .stream()

                .map(PublicacaoMapper::toResponse)

                .toList();

    }

    public PublicacaoResponse salvar(PublicacaoRequest dto){

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())

                .orElseThrow();

        Publicacao publicacao = new Publicacao();

        publicacao.setTitulo(dto.titulo());

        publicacao.setAutor(dto.autor());

        publicacao.setResumo(dto.resumo());

        publicacao.setConteudo(dto.conteudo());

        publicacao.setCategoria(categoria);

        publicacao.setDataPublicacao(LocalDate.now());

        repository.save(publicacao);

        return PublicacaoMapper.toResponse(publicacao);

    }

}